package com.example.wbdvsp2102castanedarserverjava.services;
import com.example.wbdvsp2102castanedarserverjava.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 2, "Hello From Widget 1! ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Hello From Widget 2! ABC123 ");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 1, "Hello From Widget 3! ABC234");
    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Hello From Widget 4! ABC234");
    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget createWidget(String tid, Widget widget) {
  widget.setTopicId(tid);
  widget.setId((new Date()).getTime());
  widgets.add(widget);
  return widget;
  }

  public Integer updateWidget(Long wid, Widget widget) {
    for (Widget w : widgets) {
      if (w.getId() == wid) {
        int index = widgets.indexOf(w);
        widgets.set(index, widget);
        return 1;
      } else {
        return 0;
      }
    }
    return 0;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid))
        ws.add(w);
    }
    return ws;
  }

  public Integer deleteWidget(Long id) {
    int index = -1;
    for(int i=0; i<widgets.size(); i++) {
      if (widgets.get(i).getId() == id) {
        index = i;
        widgets.remove(index);
        break;
      }
    }
    return 0;
  }
}