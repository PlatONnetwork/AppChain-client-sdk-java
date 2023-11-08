package com.platon.contracts.ppos.dto.resp;

import com.alibaba.fastjson.annotation.JSONField;
import com.platon.utils.Numeric;

import java.math.BigInteger;

public class Node {

    @JSONField(name = "NodeId", alternateNames = {"nodeId"})
    private String nodeId;

    @JSONField(name = "ValidatorId", alternateNames = {"validatorId"})
    private BigInteger validatorId;

    @JSONField(name = "StakingAddress", alternateNames = {"stakingAddress"})
    private String stakingAddress;

    @JSONField(name = "BenefitAddress", alternateNames = {"benefitAddress"})
    private String benifitAddress;

    @JSONField(name = "RewardPer", alternateNames = {"rewardPer"})
    private BigInteger rewardPer;

    @JSONField(name = "NextRewardPer", alternateNames = {"nextRewardPer"})
    private BigInteger nextRewardPer;

    @JSONField(name = "StakingTxIndex", alternateNames = {"stakingTxIndex"})
    private BigInteger stakingTxIndex;

    @JSONField(name = "ProgramVersion", alternateNames = {"programVersion"})
    private BigInteger programVersion;

    @JSONField(name = "Status", alternateNames = {"status"})
    private BigInteger status;

    @JSONField(name = "StakingEpoch", alternateNames = {"stakingEpoch"})
    private BigInteger stakingEpoch;

    @JSONField(name = "StakingBlockNum", alternateNames = {"stakingBlockNum"})
    private BigInteger stakingBlockNum;

    @JSONField(name = "Shares", alternateNames = {"shares"})
    private BigInteger shares;

    @JSONField(name = "Released", alternateNames = {"released"})
    private BigInteger released;

    @JSONField(name = "ReleasedHes", alternateNames = {"releasedHes"})
    private BigInteger releasedHes;

    @JSONField(name = "RestrictingPlan", alternateNames = {"restrictingPlan"})
    private BigInteger restrictingPlan;

    @JSONField(name = "RestrictingPlanHes", alternateNames = {"restrictingPlanHes"})
    private BigInteger restrictingPlanHes;

    @JSONField(name = "ExternalId", alternateNames = {"externalId"})
    private String externalId;

    @JSONField(name = "NodeName", alternateNames = {"nodeName"})
    private String nodeName;

    @JSONField(name = "Website", alternateNames = {"website"})
    private String website;

    @JSONField(name = "Details", alternateNames = {"details"})
    private String details;

    @JSONField(name = "ValidatorTerm", alternateNames = {"validatorTerm"})
    private BigInteger validatorTerm;

    @JSONField(name = "DelegateEpoch", alternateNames = {"delegateEpoch"})
    private BigInteger delegateEpoch;

    @JSONField(name = "DelegateTotal", alternateNames = {"delegateTotal"})
    private BigInteger delegateTotal;

    @JSONField(name = "DelegateTotalHes", alternateNames = {"delegateTotalHes"})
    private BigInteger delegateTotalHes;

    @JSONField(name = "DelegateRewardTotal", alternateNames = {"delegateRewardTotal"})
    private BigInteger delegateRewardTotal;

    public BigInteger getDelegateEpoch() {
        return delegateEpoch;
    }

    public void setDelegateEpoch(BigInteger delegateEpoch) {
        this.delegateEpoch = delegateEpoch;
    }

    public BigInteger getDelegateTotal() {
        return delegateTotal;
    }

    public void setDelegateTotal(String delegateTotal) {
        if (delegateTotal != null && delegateTotal.length() > 0) {
            this.delegateTotal = Numeric.decodeQuantity(delegateTotal);
        } else {
            this.delegateTotal = BigInteger.ZERO;
        }
    }

    public BigInteger getDelegateTotalHes() {
        return delegateTotalHes;
    }

    public void setDelegateTotalHes(String delegateTotalHes) {
        if (delegateTotalHes != null && delegateTotalHes.length() > 0) {
            this.delegateTotalHes = Numeric.decodeQuantity(delegateTotalHes);
        } else {
            this.delegateTotalHes = BigInteger.ZERO;
        }
    }

    public BigInteger getDelegateRewardTotal() {
        return delegateRewardTotal;
    }

    public void setDelegateRewardTotal(String delegateRewardTotal) {
        if (delegateRewardTotal != null && delegateRewardTotal.length() > 0) {
            this.delegateRewardTotal = Numeric.decodeQuantity(delegateRewardTotal);
        } else {
            this.delegateRewardTotal = BigInteger.ZERO;
        }
    }

    public BigInteger getValidatorId() {
        return validatorId;
    }

    public void setValidatorId(BigInteger validatorId) {
        this.validatorId = validatorId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getStakingAddress() {
        return stakingAddress;
    }

    public void setStakingAddress(String stakingAddress) {
        this.stakingAddress = stakingAddress;
    }

    public String getBenifitAddress() {
        return benifitAddress;
    }

    public void setBenifitAddress(String benifitAddress) {
        this.benifitAddress = benifitAddress;
    }

    public BigInteger getStakingTxIndex() {
        return stakingTxIndex;
    }

    public void setStakingTxIndex(BigInteger stakingTxIndex) {
        this.stakingTxIndex = stakingTxIndex;
    }

    public BigInteger getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(BigInteger programVersion) {
        this.programVersion = programVersion;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public BigInteger getStakingEpoch() {
        return stakingEpoch;
    }

    public void setStakingEpoch(BigInteger stakingEpoch) {
        this.stakingEpoch = stakingEpoch;
    }

    public BigInteger getStakingBlockNum() {
        return stakingBlockNum;
    }

    public void setStakingBlockNum(BigInteger stakingBlockNum) {
        this.stakingBlockNum = stakingBlockNum;
    }

    public BigInteger getShares() {
        return shares;
    }

    public void setShares(String shares) {
        if (shares != null && shares.length() > 0) {
            this.shares = Numeric.decodeQuantity(shares);
        } else {
            this.shares = BigInteger.ZERO;
        }
    }

    public BigInteger getReleased() {
        return released;
    }

    public void setReleased(String released) {
        if (released != null && released.length() > 0) {
            this.released = Numeric.decodeQuantity(released);
        } else {
            this.released = BigInteger.ZERO;
        }
    }

    public BigInteger getReleasedHes() {
        return releasedHes;
    }

    public void setReleasedHes(String releasedHes) {
        if (releasedHes != null && releasedHes.length() > 0) {
            this.releasedHes = Numeric.decodeQuantity(releasedHes);
        } else {
            this.releasedHes = BigInteger.ZERO;
        }
    }

    public BigInteger getRestrictingPlan() {
        return restrictingPlan;
    }

    public void setRestrictingPlan(String restrictingPlan) {
        if (restrictingPlan != null && restrictingPlan.length() > 0) {
            this.restrictingPlan = Numeric.decodeQuantity(restrictingPlan);
        } else {
            this.restrictingPlan = BigInteger.ZERO;
        }
    }

    public BigInteger getRestrictingPlanHes() {
        return restrictingPlanHes;
    }

    public void setRestrictingPlanHes(String restrictingPlanHes) {
        if (restrictingPlanHes != null && restrictingPlanHes.length() > 0) {
            this.restrictingPlanHes = Numeric.decodeQuantity(restrictingPlanHes);
        } else {
            this.restrictingPlanHes = BigInteger.ZERO;
        }
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public BigInteger getValidatorTerm() {
        return validatorTerm;
    }

    public void setValidatorTerm(BigInteger validatorTerm) {
        this.validatorTerm = validatorTerm;
    }

    public BigInteger getNextRewardPer() {
        return nextRewardPer;
    }

    public void setNextRewardPer(BigInteger nextRewardPer) {
        this.nextRewardPer = nextRewardPer;
    }

    public BigInteger getRewardPer() {
        return rewardPer;
    }

    public void setRewardPer(BigInteger rewardPer) {
        this.rewardPer = rewardPer;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId='" + nodeId + '\'' +
                ", validatorId='" + validatorId + '\'' +
                ", stakingAddress='" + stakingAddress + '\'' +
                ", benifitAddress='" + benifitAddress + '\'' +
                ", rewardPer=" + rewardPer +
                ", nextRewardPer=" + nextRewardPer +
                ", stakingTxIndex=" + stakingTxIndex +
                ", programVersion=" + programVersion +
                ", status=" + status +
                ", stakingEpoch=" + stakingEpoch +
                ", stakingBlockNum=" + stakingBlockNum +
                ", shares=" + shares +
                ", released=" + released +
                ", releasedHes=" + releasedHes +
                ", restrictingPlan=" + restrictingPlan +
                ", restrictingPlanHes=" + restrictingPlanHes +
                ", externalId='" + externalId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", website='" + website + '\'' +
                ", details='" + details + '\'' +
                ", validatorTerm=" + validatorTerm +
                ", delegateEpoch=" + delegateEpoch +
                ", delegateTotal=" + delegateTotal +
                ", delegateTotalHes=" + delegateTotalHes +
                ", delegateRewardTotal=" + delegateRewardTotal +
                '}';
    }
}
