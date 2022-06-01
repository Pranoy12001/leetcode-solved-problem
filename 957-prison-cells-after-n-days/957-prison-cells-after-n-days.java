class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int days = 0;
        
        for (int i = 0; i < n; i++) {
            int[] nextState = calculateNextState(cells);
            String nextStateStr = Arrays.toString(nextState);
            
            if (!set.contains(nextStateStr)) {
                set.add(nextStateStr);
                days++;
            } else {
                hasCycle = true;
                break;
            }
            
            cells = nextState;
        }
        
        if (hasCycle) {
            n %= days;
            for (int i = 0; i < n; i++) {
                cells = calculateNextState(cells);
            }
        }
        
        return cells;
    }
    
    private int[] calculateNextState(int[] cells) {
        int[] next = new int[cells.length];
        
        for (int i = 0; i < cells.length; i++) {
            if (i == 0 || i == cells.length - 1) {
                next[i] = 0;
            } else {
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
        }
        
        return next;
    }
}