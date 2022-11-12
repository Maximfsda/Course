enum TaskRepeatability {
    PERSONALTASK("Личная"),
    WORKINGTASK("Рабочая");

    private String name;

    TaskRepeatability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+ super.toString();
    }
}
