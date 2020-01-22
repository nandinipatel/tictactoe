class block implements global
{
    private int state;
    
    public block() {
        this.state = 0;
    }
    
    public boolean setState(final int state) {
        if (this.isValidState(state)) {
            this.state = state;
            return true;
        }
        return false;
    }
    
    public int getState() {
        return this.state;
    }
    
    public boolean isValidState(final int n) {
        return n == 2 || n == 1;
    }
    
    @Override
    public String toString() {
        if (this.state == 0) {
            return " ";
        }
        if (this.state == 1) {
            return "x";
        }
        return "o";
    }
}