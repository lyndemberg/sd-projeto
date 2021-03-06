package test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sd.oficina.customer1.dao.FabricanteDao;
import sd.oficina.shared.model.customer.Fabricante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FabricanteDaoTest {

    FabricanteDao fabricanteDao;
    Fabricante fabricante;

    @Before
    public void start() {
        fabricanteDao = new FabricanteDao();
        fabricante = new Fabricante();
        fabricante.setId(100L);
        fabricante.setNome("Fiat");
    }

    @Test
    public void test1() {
        assertNotNull(fabricanteDao.salvar(fabricante));
    }

    @Test
    public void test2() {
        assertNotNull(fabricanteDao.buscarPorId(fabricante.getId()));
    }

    @Test
    public void test3() {
        fabricante.setNome("Ford");
        assertNotNull(fabricanteDao.atualizar(fabricante));
    }

    @Test
    public void test4() {
        assertNotNull(fabricanteDao.listarTodos());
    }

    @Test
    public void test5() {
        assertEquals(true, fabricanteDao.remover(fabricante.getId()));
    }
}
