package Nodes.Consensus;

import DataStructures.Block.Block;
import DataStructures.Ledger.Ledger;
import DataStructures.Transaction.Transaction;
import network.Process;
import network.entities.CommunicationUnit;
import java.util.ArrayList;


public abstract class Consensus implements Runnable {

    @Override
    public void run() {

    }

    public void setParams(ArrayList<Block> blocks, CommunicationUnit cu, Process process, Ledger ledger, ArrayList<Transaction> transactions){

    }
    public void setParams(ArrayList<Block> blocks, CommunicationUnit cu, Process process){

    }
    public void StopMiningCurrentBlock(Block block){
    }

}