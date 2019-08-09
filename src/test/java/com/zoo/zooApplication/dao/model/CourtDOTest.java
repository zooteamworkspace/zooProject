package com.zoo.zooApplication.dao.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CourtDOTest {

	@Test
	public void testAddField() {
		CourtDO courtDO = new CourtDO();
		FieldDO mockFieldDO = mock(FieldDO.class);
		assertEquals(courtDO, courtDO.addField(mockFieldDO));
		assertEquals(Arrays.asList(new FieldDO[]{mockFieldDO}), courtDO.getFields());
		verify(mockFieldDO, times(1)).setCourt(courtDO);
	}

	@Test
	public void testFindFieldById() {
		CourtDO courtDO = new CourtDO();
		FieldDO mockFieldDO = mock(FieldDO.class);
		when(mockFieldDO.getId()).thenReturn(Long.valueOf(1));
		courtDO.addField(mockFieldDO);
		Optional<FieldDO> optionalFieldDO = courtDO.findFieldById(Long.valueOf(1));
		assertEquals(mockFieldDO, optionalFieldDO.get());

	}
}