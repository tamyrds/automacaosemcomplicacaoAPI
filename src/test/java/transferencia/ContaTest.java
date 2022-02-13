package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente Kaique;


    Conta contaXuxa;
    Conta contaKaique;

    @BeforeEach
    void setUp() {
         xuxa = new Cliente("xuxa","654545421245","4568791213");
         Kaique = new Cliente("Kaique","862312454","789632541");

         contaXuxa = new Conta("0001", "5468",2500.00,xuxa);
         contaKaique = new Conta("0002","6542",3500.00,Kaique);
    }

    @Test
    void realizarTransacao(){

        contaXuxa.realizaTransferencia(100,contaKaique);

        assertEquals(3600.00,contaKaique.getSaldo());
        assertEquals(2400.00,contaXuxa.getSaldo());

        System.out.println(contaKaique.getSaldo());
        System.out.println(contaXuxa.getSaldo());
        
    }

    @Test
    void realizaSaque(){

        contaKaique.realizarSaque(500.00);
        assertEquals(3000.0,contaKaique.getSaldo());
        System.out.println(contaKaique.getSaldo());

    }
    @Test
    void realizaTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizaTransferencia(3500,contaKaique);
        assertFalse(resultado);

    }


    @Test
    void realizaDeposito(){
        contaKaique.realizarDeposito(200);
        assertEquals(3700.00,contaKaique.getSaldo());

    }

    @Test
    void consultaProprietario(){
        contaKaique.getProprietario();

        assertEquals("Kaique","Kaique");
    }

    @Test
    void validaCFP(){
        contaKaique.getProprietario();
        assertEquals("862312454","862312454");
    }



}