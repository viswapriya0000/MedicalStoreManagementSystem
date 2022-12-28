package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.exceptionhandler.CustomerIdInvalidException;
import com.example.demo.model.Billing;
import com.example.demo.repository.BillingRepository;
import com.example.demo.service.BillingServiceImpl;

@SpringBootTest
public class BillingServiceTests {
	
	@MockBean
	BillingRepository billRepo;
	
	@Autowired
	BillingServiceImpl billSer;
	
	@Test
	public void getAllBills() {
		List<Billing> bill=new ArrayList<>();
		when(billRepo.findAll()).thenReturn(bill);
		assertEquals(0,billSer.getAllBills().size());
	}
	
	@Test
	public void billCancel() throws CustomerIdInvalidException{
		Long id=3L;
		Billing bill=new Billing();
		bill.setTotalAmount(5000l);
		bill.setAddress("AP");
		bill.setBillId(id);
		when(billRepo.findByBillId(id)).thenReturn(bill);
		assertEquals("bill is cancelled with id "+ id,billSer.billCancel(id));
	}

}
