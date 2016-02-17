package com.sample.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Cliente;
import com.sample.model.Venta;

public class RuleTest {


	@Test
	public void testGoldMealRule() {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		

		Cliente cliente1 = new Cliente("Habitual", "Electronicos", 19);
		Venta venta = new Venta();
		venta.setMontoTotal(new BigDecimal(205.0));
		venta.setRecargos(new BigDecimal(0.0));

		kSession.insert(cliente1);
		kSession.insert(venta);
		kSession.fireAllRules();

		assertTrue("Se cobró el recargo esperado", venta.getRecargos().compareTo(BigDecimal.ZERO) > 0);
		
		
		if (kSession != null) {
			kSession.dispose();
		}

	}
}