package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

public class MotionScene {
    ArrayList<ConstraintSet> mConstraintSets = new ArrayList<>();
    ArrayList<Transition> mTransitions = new ArrayList<>();

    public void addConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSets.add(constraintSet);
    }

    public void addTransition(Transition transition) {
        this.mTransitions.add(transition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        int i4 = 0;
        if (!this.mTransitions.isEmpty()) {
            sb.append("Transitions:{\n");
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Transition transition = arrayList.get(i5);
                i5++;
                sb.append(transition.toString());
            }
            sb.append("},\n");
        }
        if (!this.mConstraintSets.isEmpty()) {
            sb.append("ConstraintSets:{\n");
            ArrayList<ConstraintSet> arrayList2 = this.mConstraintSets;
            int size2 = arrayList2.size();
            while (i4 < size2) {
                ConstraintSet constraintSet = arrayList2.get(i4);
                i4++;
                sb.append(constraintSet.toString());
            }
            sb.append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
