package DataStructures.Ledger;

import DataStructures.Block.Block;
import DataStructures.Ledger.PartitionsTree.TransientPartitionTree;

import java.security.NoSuchAlgorithmException;

public class Ledger {


    private LedgerPartition baseLedger;
    private TransientPartitionTree partitionTree;
    private int transientLedgerMaxLength;

    public Ledger() {
        baseLedger = new LedgerPartition(0);
        partitionTree = new TransientPartitionTree();
        transientLedgerMaxLength = 10;
    }

    public boolean addBlock(Block block) throws NoSuchAlgorithmException {
//        if(!partitionTree.addBlock(block))
//            return false;
//        if (partitionTree.getMaxBranchDepth() > transientLedgerMaxLength) {
//            Block tmp = partitionTree.removeFirstBlock();
//            baseLedger.addBlock(tmp);
//        }
//        return true;
        return baseLedger.addBlock(block);
    }

    public UTXOEntry[] getAvailableUTXOsForPublicKey(String publicKeyHash) {

        //TODO check validity
//        return partitionTree.getLongestBranchUTXOSet();
        return baseLedger.getUTXOsAvailableForPublicKey(publicKeyHash);
    }


    public int getLegderDepth() {

        //TODO Change
        return baseLedger.getDepth();
    }
    public boolean isValidBlockForLedger(Block b) throws NoSuchAlgorithmException {
        return this.baseLedger.isValidBlockForLedger(b);
    }
}
