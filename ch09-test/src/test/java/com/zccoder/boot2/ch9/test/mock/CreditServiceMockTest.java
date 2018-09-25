package com.zccoder.boot2.ch9.test.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.lt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import com.zccoder.boot2.ch9.test.service.CreditSystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreditServiceMockTest {
	@Test
	public void test() throws IOException {
		

		int userId = 10;
		// 创建mock对象
		CreditSystemService creditService = mock(CreditSystemService.class);
		// 模拟mock对象调用
		when(creditService.getUserCredit(eq(userId))).thenReturn(1000);
		// 实际调用
		int ret = creditService.getUserCredit(userId);
		//注释如下行，单元测试会失败
		creditService.getUserCredit(userId);
		// 比较期望值和返回值
		assertEquals(1000, ret);
		verify(creditService, times(2)).getUserCredit(eq(userId));

	}

	@Test
	public void test2() {
		int userId = 10;
		// 创建mock对象
		CreditSystemService creditService = mock(CreditSystemService.class);
		// 模拟mock对象调用
		when(creditService.getUserCredit(eq(userId))).thenReturn(1000);
		when(creditService.getUserCredit(lt(0))).thenThrow(new IllegalArgumentException("userId不能小于0"));
		
		try{
			// 实际调用
			int ret = creditService.getUserCredit(10);
			Assert.assertEquals(1000, ret);
			 ret = creditService.getUserCredit(-1);
			Assert.fail();
		}catch(IllegalArgumentException e){
			//应该抛出异常
		}
		
		
		


	}
	
	@Test
	public void test3() {
		
		// 创建mock对象
		List list = mock(List.class);
		doThrow(new UnsupportedOperationException("不支持clear方法调用")).when(list).clear();;
		try {
			list.clear();
			
		}catch(UnsupportedOperationException x) {
			return ;
		}
		Assert.fail();


	}
}
