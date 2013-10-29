package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.service.HotelService;
import junit.framework.Assert;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Jakub Polak, Jan Hrubes
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class HotelServiceImplTest extends TestServiceSetup
{
    @Mock
    private HotelDao hotelDao;

    @Autowired
    @InjectMocks
    private HotelService hotelService;

    @Test
    public void testFindAll() throws Exception {
        List<HotelDto> hotelDtos = hotelService.findAll();

        Assert.assertEquals(hotelDtos.size(), 3);
    }

    @Test
    public void testFindByCriteria() throws Exception {
        List<HotelDto> hotelDtos1 = hotelService.findByCriteria(Restrictions.eq("name", "Hotel New York"));

        Assert.assertEquals(hotelDtos1.size(), 1);

        List<HotelDto> hotelDtos2 = hotelService.findByCriteria(Restrictions.eq("id", 999L));

        Assert.assertTrue(hotelDtos2.isEmpty());
    }

    @Test
    public void testFind() throws Exception {
        Assert.assertNotNull(hotelService.find(2L));
        Assert.assertNull(hotelService.find(999L));
    }

    @Test
    public void testCreate() throws Exception {
        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setName("Hotel Bratislava");
        hotelService.create(hotelDto);

        List<HotelDto> hotelDtos = hotelService.findByCriteria(Restrictions.eq("name", "Hotel Bratislava"));

        Assert.assertEquals(1, hotelDtos.size());
    }

    @Test
    public void testUpdate() throws Exception {
        HotelDto hotelDto = hotelService.find(1L);
        hotelDto.setName("Update Hotel name");

        hotelService.update(hotelDto);

        List<HotelDto> hotelDtos = hotelService.findByCriteria(Restrictions.eq("name", "Update Hotel name"));

        Assert.assertEquals(hotelDtos.size(), 1);
    }

    @Test
    public void testDelete() throws Exception {
        hotelService.delete(hotelService.find(1L));

        Assert.assertNull(hotelService.find(1L));
    }
}
