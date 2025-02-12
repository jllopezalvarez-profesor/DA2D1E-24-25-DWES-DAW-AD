package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.dto;

public class NewTaskAssignmentDto {
    private int taskId;
    private int familyMemberId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(int familyMemberId) {
        this.familyMemberId = familyMemberId;
    }
}

