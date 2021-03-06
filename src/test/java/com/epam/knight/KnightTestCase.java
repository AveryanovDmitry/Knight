package com.epam.knight;

import com.epam.knight.model.Knight;
import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KnightTestCase {

    @Mock
    private Ammunition sword;

    @Mock
    private Ammunition helmet;

    @Test
    public void testCalculateAmmunitionCost() {
        Knight knight = new Knight();
        KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);

        when(sword.getCost()).thenReturn(10);
        when(helmet.getCost()).thenReturn(20);

        manager.equipAmmunitionToKnight(sword);
        manager.equipAmmunitionToKnight(helmet);

        assertThat("Wrong result of method calculateAmmunitionCost (sword cost is 10, helmet cost is 20)", 30, is(manager.calculateAmmunitionCost()));
    }

    @Test
    public void testCalculateAmmunitionWeight() {
        Knight knight = new Knight();
        KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);

        when(sword.getWeight()).thenReturn(15);
        when(helmet.getWeight()).thenReturn(5);

        manager.equipAmmunitionToKnight(sword);
        manager.equipAmmunitionToKnight(helmet);

        assertThat("Wrong result of method CalculateAmmunitionWeight (sword weight is 15, helmet weight is 5)", 20, is(manager.calculateAmmunitionWeight()));
    }

}
