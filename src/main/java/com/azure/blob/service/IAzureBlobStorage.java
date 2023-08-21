package com.azure.blob.service;

import com.azure.blob.exception.AzureBlobStroageException;
import com.azure.blob.model.Storage;

import java.util.List;

public interface IAzureBlobStorage {

    public String write(Storage storage) throws AzureBlobStroageException;
    public String update(Storage storage) throws AzureBlobStroageException;

    public byte[] read(Storage storage) throws AzureBlobStroageException;

    public List<String> listFiles(Storage storage) throws AzureBlobStroageException;

    public void delete(Storage storage) throws AzureBlobStroageException;

    public void createContainer() throws AzureBlobStroageException;

    public void deleteContainer() throws AzureBlobStroageException;

}
