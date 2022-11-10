package com.example.Workbench_demo.service;

import com.example.workbench_demo.model.Domain;
import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.repository.DomainRepository;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.service.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UtilsTest {
    @Mock
    private DomainRepository domainRepository;
    @Mock
    private EngagementRepository engagementRepository;

    @Test
    void testGetEngagementById() {
        //Given
        when(engagementRepository.findById(any())).thenReturn(Optional.empty());

        //When
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> Utils.getEngagementById(null, engagementRepository));

        //Then
        assertEquals("Engagement with given ID not found", e.getMessage());
    }

    @Test
    void testAddDomains() {
        //Given
        Engagement engagement = new Engagement();
        Domain d1 = new Domain();
        d1.setName("google");
        engagement.setDomains(Arrays.asList());
        when(engagementRepository.findById(any())).thenReturn(Optional.of(new Engagement()));

        //When
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> Utils.getEngagementById(null, engagementRepository));

        //Then
        assertEquals("Engagement with given ID not found", e.getMessage());
    }

}
