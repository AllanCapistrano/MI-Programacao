package br.uefs.ecomp.ccma;

import br.uefs.ecomp.ccma.model.*;
import br.uefs.ecomp.ccma.util.ListTest;
import br.uefs.ecomp.ccma.util.MyTreeImagesTest;
import br.uefs.ecomp.ccma.util.MyTreeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ComputerTest.class,
    MedicalImageTest.class,
    SystemTest.class,
    ListTest.class,
    MyTreeTest.class,
    MyTreeImagesTest.class
})

public class AllTestes {
    
}
