package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.service.RoomService;
import junit.framework.Assert;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jakub Polak, Jan Hrubes
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceImplTest extends TestServiceSetup
{
    @Mock
    RoomDao roomDao;

    @Autowired
    @InjectMocks
    RoomService roomService;

    @Test
    public void testFindAll() throws Exception {
        List<RoomDto> roomDtos = roomService.findAll();

        Assert.assertEquals(8, roomDtos.size());
    }

    @Test
    public void testFindByCriteria() throws Exception {
        List<RoomDto> roomDtos1 = roomService.findByCriteria(Restrictions.eq("number", "101"));

        Assert.assertEquals(2, roomDtos1.size());

        List<RoomDto> roomDtos2 = roomService.findByCriteria(Restrictions.eq("number", "999"));

        Assert.assertTrue(roomDtos2.isEmpty());
    }

    @Test
    public void testFind() throws Exception {
        Assert.assertNotNull(roomService.find(1L));
        Assert.assertNull(roomService.find(999L));
    }

    @Test
    public void testCreate() throws Exception {
        RoomDto roomDto = new RoomDtoImpl();
        roomDto.setNumber("456");
        roomDto.setPrice(new BigDecimal(99.99));

        roomService.create(roomDto);

        List<RoomDto> roomDtos = roomService.findByCriteria(Restrictions.eq("number", "465"));

        Assert.assertEquals(roomDtos.size(), 1);
    }

    @Test
    public void testUpdate() throws Exception {
        RoomDto roomDto = roomService.find(8L);
        roomDto.setNumber("689");

        roomService.update(roomDto);

        List<RoomDto> roomDtos = roomService.findByCriteria(Restrictions.eq("number", "689"));

        Assert.assertEquals(1, roomDtos.size());
    }

    @Test
    public void testDelete() throws Exception {
        roomService.delete(roomService.find(1L));

        Assert.assertNull(roomService.find(1L));
    }
}
