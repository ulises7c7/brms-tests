package com.sample;

import java.math.BigDecimal;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Cliente;
import com.sample.model.Venta;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Cliente cliente1 = new Cliente("Habitual", "Electronicos" , 19 );
            Venta venta = new Venta();
            venta.setMontoTotal(new BigDecimal(205.0));
            venta.setRecargos(new BigDecimal(0.0));
            
            kSession.insert(cliente1);
            kSession.insert(venta);
            kSession.fireAllRules();
            
            System.out.println("total de recargos de la venta: " + venta.getRecargos());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }



}
