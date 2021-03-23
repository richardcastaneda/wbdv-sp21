package com.example.wbdvsp2102castanedarserverjava.services;
import com.example.wbdvsp2102castanedarserverjava.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
//CRUD operations for Widgets

@Service
public class WidgetService {

  private List<Widget> widgets = new ArrayList<Widget>();

  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to Widget List");
    Widget w2 = new Widget(234l, "ABC234", "Test2", 1, "Welcome to Widget List");
    Widget w3 = new Widget(345l, "ABC345", "Test3", 1, "Welcome to Widget List");
    Widget w4 = new Widget(456l, "ABC456", "Test4", 1, "Welcome to Widget List");
    Widget w5 = new Widget(567l, "ABC567", "Test5", 1, "Welcome to Widget List");
    Widget w6 = new Widget(678l, "ABC678", "PARAGRAPH", 1, "Welcome to Widget List");
    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
    widgets.add(w6);
  }

  public Widget createWidgetForTopic(String topicId, Widget widget) {
  widget.setTopicId(topicId);
  widget.setId((new Date()).getTime());
  widget.setType("HEADING");
  widgets.add(widget);
  return widget;
  }


  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(topicId))
        ws.add(w);
    }
    return ws;
  }
}
