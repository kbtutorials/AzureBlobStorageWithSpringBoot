package com.azure.blob;


import com.azure.blob.exception.AzureBlobStroageException;
import com.azure.blob.model.Storage;
import com.azure.blob.service.impl.AzureBlobStorageImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
class AzureBlobServicesApplicationTests {

	@Autowired
	AzureBlobStorageImpl storageImpl;

	@Test
	void contextLoads() {
	}
	@BeforeEach
	public void createContainer() throws AzureBlobStroageException {
		storageImpl.createContainer();
	}

	@AfterEach
	public void deleteContainer() throws AzureBlobStroageException {
	storageImpl.deleteContainer();
	}
	@Test
	public  void writeBlob() throws AzureBlobStroageException {
		Storage storage = getStorage("cust","cust1.txt","Hello World");
		String writeStr = storageImpl.write(storage);
		 storage = getStorage("cust","cust1.txt","Hello World1");
		String updateStr = storageImpl.update(storage);
		List<String> listFiles = storageImpl.listFiles(storage);
		System.out.println(listFiles);
		byte[] readContents =storageImpl.read(storage);
		System.out.println(readContents);
		storageImpl.delete(storage);

	}

	private Storage getStorage(String path ,String fileName,String data){
		Storage storage = new Storage();
		storage.setPath(path);
		storage.setFileName(fileName);
		if(StringUtils.isNotBlank(data)){
			storage.setInputStream(new ByteArrayInputStream(data.getBytes()));
		}

		return storage;
	}
}
