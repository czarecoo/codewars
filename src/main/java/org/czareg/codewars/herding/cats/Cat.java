package org.czareg.codewars.herding.cats;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@AllArgsConstructor
public class Cat implements Comparable<Cat> {

    @NonNull
    public String name;
    public double weight;

    @Override
    public int compareTo(Cat o) {
        return name.compareTo(o.name);
    }
}
