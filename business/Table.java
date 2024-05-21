package business;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Table {
    private int tableId;
    private String status; //reserved or free

    public Table(int tableId, String status) {
        this.tableId = tableId;
        this.status = status;
    }
}
