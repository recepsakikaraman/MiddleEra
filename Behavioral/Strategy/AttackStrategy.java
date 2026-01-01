package Behavioral.Strategy;

import java.util.List;

import Creational.Factory.Soldier;

public interface AttackStrategy {
    void execute(List<Soldier> soldiers);

    String getName();

    String getDescription();
}
