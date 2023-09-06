package Application.Model.Interfaces;

import Application.Model.Entities.Task;

public interface ModelListListeners
{
    void onAddedItem(Task task);
    void onUpdatedItem();
}
