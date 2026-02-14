class Car {
    int position;
    double timeToTarget;

    Car(int position, double timeToTarget) {
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        Car[] cars = new Car[n];

        // Step 1: Calculate time
        for (int i = 0; i < n; i++) {
            double time = (target - position[i]) * 1.0 / speed[i];
            cars[i] = new Car(position[i], time);
        }

        // Step 2: Sort by position
        Arrays.sort(cars, (a, b) -> a.position - b.position);

        int fleets = 0;
        double maxTime = 0;

        // Step 3: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (cars[i].timeToTarget > maxTime) {
                fleets++;
                maxTime = cars[i].timeToTarget;
            }
        }

        return fleets;
    }
}
