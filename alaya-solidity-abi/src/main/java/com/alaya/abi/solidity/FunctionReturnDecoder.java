package com.alaya.abi.solidity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alaya.abi.solidity.datatypes.generated.Bytes32;
import com.alaya.abi.solidity.datatypes.Array;
import com.alaya.abi.solidity.datatypes.Bytes;
import com.alaya.abi.solidity.datatypes.BytesType;
import com.alaya.abi.solidity.datatypes.DynamicArray;
import com.alaya.abi.solidity.datatypes.DynamicBytes;
import com.alaya.abi.solidity.datatypes.StaticArray;
import com.alaya.abi.solidity.datatypes.Type;
import com.alaya.abi.solidity.datatypes.Utf8String;
import com.alaya.utils.Numeric;
import com.alaya.utils.Strings;

/**
 * Decodes values returned by function or event calls.
 */
public class FunctionReturnDecoder {

    private FunctionReturnDecoder() { }

    /**
     * Decode ABI encoded return values from smart contract function call.
     *
     * @param rawInput ABI encoded input
     * @param outputParameters list of return types as {@link TypeReference}
     * @return {@link List} of values returned by function, {@link Collections#emptyList()} if
     *         invalid response
     */
    public static List<Type> decode(
            String rawInput, List<TypeReference<Type>> outputParameters, long chainId) {
        String input = Numeric.cleanHexPrefix(rawInput);

        if (Strings.isEmpty(input)) {
            return Collections.emptyList();
        } else {
            return build(input, outputParameters, chainId);
        }
    }

    /**
     * <p>Decodes an indexed parameter associated with an event. Indexed parameters are individually
     * encoded, unlike non-indexed parameters which are encoded as per ABI-encoded function
     * parameters and return values.</p>
     *
     * <p>If any of the following types are indexed, the Keccak-256 hashes of the values are
     * returned instead. These are returned as a bytes32 value.</p>
     *
     * <ul>
     *     <li>Arrays</li>
     *     <li>Strings</li>
     *     <li>Bytes</li>
     * </ul>
     *
     * <p>See the
     * <a href="http://solidity.readthedocs.io/en/latest/contracts.html#events">
     * Solidity documentation</a> for further information.</p>
     *
     * @param rawInput ABI encoded input
     * @param typeReference of expected result type
     * @param <T> type of TypeReference
     * @return the decode value
     */
    @SuppressWarnings("unchecked")
    public static <T extends Type> Type decodeIndexedValue(
            String rawInput, TypeReference<T> typeReference, long chainId) {
        String input = Numeric.cleanHexPrefix(rawInput);

        try {
            Class<T> type = typeReference.getClassType();

            if (Bytes.class.isAssignableFrom(type)) {
                return TypeDecoder.decodeBytes(input, (Class<Bytes>) Class.forName(type.getName()));
            } else if (Array.class.isAssignableFrom(type)
                    || BytesType.class.isAssignableFrom(type)
                    || Utf8String.class.isAssignableFrom(type)) {
                return TypeDecoder.decodeBytes(input, Bytes32.class);
            } else {
                return TypeDecoder.decode(input, type, chainId);
            }
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Invalid class reference provided", e);
        }
    }

    private static List<Type> build(
            String input, List<TypeReference<Type>> outputParameters, long chainId) {
        List<Type> results = new ArrayList<>(outputParameters.size());

        int offset = 0;
        for (TypeReference<?> typeReference:outputParameters) {
            try {
                @SuppressWarnings("unchecked")
                Class<Type> type = (Class<Type>) typeReference.getClassType();

                int hexStringDataOffset = getDataOffset(input, offset, type, chainId);

                Type result;
                if (DynamicArray.class.isAssignableFrom(type)) {
                    result = TypeDecoder.decodeDynamicArray(
                            input, hexStringDataOffset, typeReference, chainId);
                    offset += TypeDecoder.MAX_BYTE_LENGTH_FOR_HEX_STRING;
                } else if (typeReference instanceof TypeReference.StaticArrayTypeReference) {
                    int length = ((TypeReference.StaticArrayTypeReference) typeReference).getSize();
                    result = TypeDecoder.decodeStaticArray(
                            input, hexStringDataOffset, typeReference, length,chainId);
                    offset += length * TypeDecoder.MAX_BYTE_LENGTH_FOR_HEX_STRING;
                } else if (StaticArray.class.isAssignableFrom(type)) {
                    int length = Integer.parseInt(type.getSimpleName()
                            .substring(StaticArray.class.getSimpleName().length()));
                    result = TypeDecoder.decodeStaticArray(
                            input, hexStringDataOffset, typeReference, length,chainId);
                    offset += length * TypeDecoder.MAX_BYTE_LENGTH_FOR_HEX_STRING;
                } else {
                    result = TypeDecoder.decode(input, hexStringDataOffset, type, chainId);
                    offset += TypeDecoder.MAX_BYTE_LENGTH_FOR_HEX_STRING;
                }
                results.add(result);

            } catch (ClassNotFoundException e) {
                throw new UnsupportedOperationException("Invalid class reference provided", e);
            }
        }
        return results;
    }

    private static <T extends Type> int getDataOffset(String input, int offset, Class<T> type, long chainId) {
        if (DynamicBytes.class.isAssignableFrom(type)
                || Utf8String.class.isAssignableFrom(type)
                || DynamicArray.class.isAssignableFrom(type)) {
            return TypeDecoder.decodeUintAsInt(input, offset, chainId) << 1;
        } else {
            return offset;
        }
    }
}