public class list6 {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 5, 2);
        scheduler.addProcess(2, 8, 1);
        scheduler.addProcess(3, 4, 3);
        scheduler.addProcess(4, 6, 1);
        scheduler.simulateRoundRobin(3);
    }
}

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void simulateRoundRobin(int quantum) {
        if (head == null) return;

        int time = 0;
        int totalProcesses = countProcesses();
        int completed = 0;
        int[] waitingTime = new int[totalProcesses];
        int[] turnaroundTime = new int[totalProcesses];

        Process current = head;

        while (completed < totalProcesses) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(quantum, current.remainingTime);
                time += execTime;
                current.remainingTime -= execTime;

                if (current.remainingTime == 0) {
                    int index = current.pid - 1;
                    turnaroundTime[index] = time;
                    waitingTime[index] = time - current.burstTime;
                    completed++;
                }
            }
            current = current.next;
        }

        for (int i = 0; i < totalProcesses; i++) {
            System.out.println("Process " + (i + 1) + ": Waiting = " + waitingTime[i] + ", Turnaround = " + turnaroundTime[i]);
        }

        float totalWT = 0, totalTAT = 0;
        for (int i = 0; i < totalProcesses; i++) {
            totalWT += waitingTime[i];
            totalTAT += turnaroundTime[i];
        }

        System.out.printf("Avg Waiting Time: %.2f\n", totalWT / totalProcesses);
        System.out.printf("Avg Turnaround Time: %.2f\n", totalTAT / totalProcesses);
    }

    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process current = head;
        while (true) {
            count++;
            current = current.next;
            if (current == head) break;
        }
        return count;
    }
}