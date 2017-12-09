package fr.marethyun.battlecard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickFactory {

    public static ArrayDeque<Card> newPick(){
        return newPick(1);
    }

    public static ArrayDeque<Card> newPick(int picks){
        List<Card> list = new ArrayList<>();

        for (int i = 0; i < picks; i++) {
            for (CardType type : CardType.values()) {
                if (type.equals(CardType.JOKER)) {
                    for (int j = 0; j < 2; j++) {
                        list.add(new Card(type, CardColor.NONE));
                    }
                } else {
                    for (CardColor color : CardColor.values()) {
                        if (color.equals(CardColor.NONE)) continue;
                        list.add(new Card(type, color));
                    }
                }
            }
        }

        System.out.println(list.size());

        Collections.shuffle(list);

        return new ArrayDeque<>(list);
    }
}
