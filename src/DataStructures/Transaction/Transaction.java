package DataStructures.Transaction;

import DataStructures.Ledger.UTXOSet;
import Utils.BytesConverter;
import Utils.RSA;
import Utils.SHA;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Transaction {

    public int version = 1;
    public int inputCounter = 0;
    public int outputCounter = 0;
    public int lockTime = 0;

    public TransactionInput[] transactionInputs;
    public TransactionOutput[] transactionOutputs;



    public TransactionOutput[] getTransactionOutputs() {
        return transactionOutputs;
    }

    public TransactionInput[] getTransactionInputs() {
        return transactionInputs;
    }

    public byte[] getTransactionHash() throws NoSuchAlgorithmException {

        ArrayList<byte[]> fieldsBytes = new ArrayList<>();
        fieldsBytes.add(BytesConverter.intToBytes(version));
        fieldsBytes.add(BytesConverter.intToBytes(inputCounter));
        fieldsBytes.add(BytesConverter.intToBytes(outputCounter));
        fieldsBytes.add(BytesConverter.intToBytes(lockTime));

        for (int i = 0; i < transactionInputs.length ; i++) {
            fieldsBytes.add(transactionInputs[i].getByteRepresentation());
        }

        for (int i = 0; i < transactionOutputs.length ; i++) {
            fieldsBytes.add(transactionOutputs[i].getByteRepresentation());
        }

        return SHA.getSHA(BytesConverter.concatenateByteArrays(fieldsBytes));

    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        TransactionInput i1 =  new TransactionInput();
        TransactionInput i2 =  new TransactionInput();
        TransactionInput i3 =  new TransactionInput();
        TransactionInput i4 =  new TransactionInput();
        TransactionInput i5 =  new TransactionInput();



        i1.publicKey = BigInteger.probablePrime(256, new SecureRandom());
        i1.publicKeyModulus = BigInteger.probablePrime(256, new SecureRandom());
        i1.signature = BigInteger.probablePrime(256, new SecureRandom());
        i1.transactionHash = "Ah ya 7osty l soda yany yama".getBytes();

        i2.publicKey = BigInteger.probablePrime(256, new SecureRandom());
        i2.publicKeyModulus = BigInteger.probablePrime(256, new SecureRandom());
        i2.signature = BigInteger.probablePrime(256, new SecureRandom());
        i2.transactionHash = "Ah ya 7osty l soda yany yama".getBytes();

        i3.publicKey = BigInteger.probablePrime(256, new SecureRandom());
        i3.publicKeyModulus = BigInteger.probablePrime(256, new SecureRandom());
        i3.signature = BigInteger.probablePrime(256, new SecureRandom());
        i3.transactionHash = "Ah ya 7osty l soda yany yama".getBytes();

        i4.publicKey = BigInteger.probablePrime(256, new SecureRandom());
        i4.publicKeyModulus = BigInteger.probablePrime(256, new SecureRandom());
        i4.signature = BigInteger.probablePrime(256, new SecureRandom());
        i4.transactionHash = "Ah ya 7osty l soda yany yama".getBytes();



        TransactionOutput o1 = new TransactionOutput();
        TransactionOutput o2 = new TransactionOutput();
        TransactionOutput o3 = new TransactionOutput();
        TransactionOutput o4 = new TransactionOutput();
        TransactionOutput o5 = new TransactionOutput();


        o1.amount = 5000;
        o1.publicKeyHash = "Ah ya 7osty l soda yany yama".getBytes();

        o2.amount = 5000;
        o2.publicKeyHash = "Ah ya 7osty l soda yany yama".getBytes();

        o3.amount = 5000;
        o3.publicKeyHash = "Ah ya 7osty l soda yany yama".getBytes();

        o4.amount = 5000;
        o4.publicKeyHash = "Ah ya 7osty l soda yany yAma".getBytes();

        Transaction t1 = new NormalTransaction();
        Transaction t2 = new NormalTransaction();

        t1.transactionInputs = new TransactionInput[]{i1, i2, i3};
        t2.transactionInputs = new TransactionInput[]{i1, i2, i3};

        t1.transactionOutputs = new TransactionOutput[]{o1, o2 , o3};
        t2.transactionOutputs = new TransactionOutput[]{o1, o2 , o3};



        byte[] h1 = t1.getTransactionHash();
        byte[] h2 = t2.getTransactionHash();


        System.out.println(BytesConverter.byteToHexString(h1, 32));
        System.out.println(BytesConverter.byteToHexString(h2, 32));

    }


    public abstract boolean validateInputOutputDifference(long sum);

}