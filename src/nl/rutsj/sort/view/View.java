package nl.rutsj.sort.view;

import nl.rutsj.sort.util.DataPair;

public interface View {
    void update(DataPair[] data);

    void setTitle(String title);

    void setStatus(String status);
}
