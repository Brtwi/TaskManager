package Application.Model;

import Application.Model.Entities.Task;

public interface ModelListListeners
{
    void onAddedItem(Task task);
    void onUpdatedItem();
}
