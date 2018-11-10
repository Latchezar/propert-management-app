package com.property.landlordapp;

import com.property.landlordapp.repositories.SQLRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {

    ModelsInitialization data = new ModelsInitialization();

    @InjectMocks
    SQLRepository repository;

    @Test
    public void testSha1Algoryth_ShouldGiveSha1String(){
        String test = "thegame";
        test = repository.sha1(test);

        Assert.assertEquals("", test);
    }

}
