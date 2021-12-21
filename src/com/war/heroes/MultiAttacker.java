package com.war.heroes;

import com.war.Army;

public interface MultiAttacker {
    void doAttack(Army army);
    boolean isAlive();
}
