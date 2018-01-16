package com.wlopera.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator implements BundleActivator,  ServiceListener {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Iniciar servicio OSGI!!");
		context.addServiceListener(this);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Finalizar servicio OSGI!!");	
		context.removeServiceListener(this);
	}
	

	 /**
     * Implementa ServiceListener.serviceChanged().
     * Imprime los detalles del servicio Framework
     * @param evento
    **/
    public void serviceChanged(ServiceEvent event)
    {
        String[] objectClass = (String[])
            event.getServiceReference().getProperty("objectClass");

        if (event.getType() == ServiceEvent.REGISTERED)
        {
            System.out.println(
                "Tipo de servicio: " + objectClass[0] + " registered.");
        }
        else if (event.getType() == ServiceEvent.UNREGISTERING)
        {
            System.out.println(
                "Tipo de servicio" + objectClass[0] + " unregistered.");
        }
        else if (event.getType() == ServiceEvent.MODIFIED)
        {
            System.out.println(
                "Tipo de servicio " + objectClass[0] + " modified.");
        }
    }
}
