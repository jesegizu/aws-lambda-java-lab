package com.lambda.gradle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StateIMCTest {
    @org.junit.Test
    public void stateInfrapesoSeveroIMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(15.0);
        String state = stateIMC.get();
        assertEquals("Infrapeso: Delgadez Severa",state);
    }

    @org.junit.Test
    public void stateInfrapesoModeradoIMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(16.5);
        String state = stateIMC.get();
        assertEquals("Infrapeso: Delgadez Moderada",state);
    }

    @org.junit.Test
    public void stateInfrapesoAceptableIMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(17.5);
        String state = stateIMC.get();
        assertEquals("Infrapeso: Delgadez Aceptable",state);
    }

    @org.junit.Test
    public void stateNormalIMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(22.5);
        String state = stateIMC.get();
        assertEquals("Peso Normal",state);
    }

    @org.junit.Test
    public void stateSobrepesoIMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(28.5);
        String state = stateIMC.get();
        assertEquals("Bendiiiiito",state);
    }

    @org.junit.Test
    public void stateObesoTipo1IMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(32.5);
        String state = stateIMC.get();
        assertEquals("Obeso: Tipo I",state);
    }

    @org.junit.Test
    public void stateObesoTipo2IMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(36.5);
        String state = stateIMC.get();
        assertEquals("Obeso: Tipo II",state);
    }

    @org.junit.Test
    public void stateObesoTipo3IMC() throws Exception{
        StateFactory stateFactory = new StateFactory();
        State stateIMC = stateFactory.getState(43.5);
        String state = stateIMC.get();
        assertEquals("Obeso: Tipo III",state);
    }

    @Test
    public void getNormalWeight() throws Exception{
        IMC objectIMC = new IMC();
        Double normalWeight = objectIMC.getNormalWeight(80,1.70);
        assertEquals(72,normalWeight,0.2);
    }
}
