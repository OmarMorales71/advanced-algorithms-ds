package omar.algorithms.greedy;

import java.util.Arrays;

public class ActivitySelection {

    public static void main(String args[]) {
        Actividad[] activities = new Actividad[6];
        
        activities[0]=new Actividad("1", 1, 2);
        activities[1]=new Actividad("3", 7, 8);
        activities[2]=new Actividad("6", 11, 12);
        activities[3]=new Actividad("5", 1, 10);
        activities[4]=new Actividad("2", 2, 4);
        activities[5]=new Actividad("4", 2, 9);
        
        System.out.println(activitySelectionProblem(activities));
    }

    public static int activitySelectionProblem(Actividad[] activities) {
        Arrays.sort(activities);
        int actitiviesMax=1;
        Actividad previousActivity;
        if (activities.length != 0) {
            previousActivity = activities[0];
             System.out.println(previousActivity);
        }else{
            return 0;
        }
        
        for(int i=1 ; i<activities.length;i++){
            if(activities[i].start>=previousActivity.finish){
                actitiviesMax++;
                System.out.println(activities[i]);
                previousActivity=activities[i];
            }
        }
        return actitiviesMax;
    }

    
}
class Actividad implements Comparable<Actividad> {

        int start;
        int finish;
        String name;

        public Actividad(String name, int start, int finish) {
            this.start = start;
            this.finish = finish;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Actividad{" + "name=" + name + '}';
        }

        @Override
        public int compareTo(Actividad t) {
            return this.finish - t.finish;
        }

    }