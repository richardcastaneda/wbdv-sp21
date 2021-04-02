package com.example.wbdvsp2102castanedarserverjava.services;
import com.example.wbdvsp2102castanedarserverjava.models.Widget;
import com.example.wbdvsp2102castanedarserverjava.repositories.WidgetRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

//  private List<Widget> widgets = new ArrayList<Widget>();
//  {
//    Widget w1 = new Widget(123l, "ABC123", "HEADING", 2, "Hello From Widget 1! ABC123");
//    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Hello From Widget 2! ABC123 ");
//    Widget w3 = new Widget(345l, "ABC234", "HEADING", 1, "Hello From Widget 3! ABC234");
//    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Hello From Widget 4! ABC234");
//    widgets.add(w1);
//    widgets.add(w2);
//    widgets.add(w3);
//    widgets.add(w4);
//  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
    //return widgets;
  }

  public Widget createWidget(String tid, Widget widget) {
    widget.setTopicId(tid);
    return repository.save(widget);
//  widget.setId((new Date()).getTime());
//  widgets.add(widget);
//  return widget;
  }

  public int updateWidget(Long wid, Widget widget) {
    Widget originalWidget = repository.findById(wid).get();
    originalWidget.setText(widget.getText());
    //TODO: COPY EVERYTHING OVER ALL FIELDS FOR WIDGET
    repository.save(originalWidget);
    return 1;
//    for (Widget w : widgets) {
//      if (w.getId() == wid) {
//        int index = widgets.indexOf(w);
//        widgets.set(index, widget);
//        return 1;
//      } else {
//        return 0;
//      }
//    }
//    return 0;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return repository.findWidgetsForTopic(tid);
//    List<Widget> ws = new ArrayList<Widget>();
//    for (Widget w : widgets) {
//      if (w.getTopicId().equals(tid))
//        ws.add(w);
//    }
//    return ws;
  }

  public Widget findWidgetById(Long wid) {
    return repository.findWidgetById(wid);
  }

  public Integer deleteWidget(Long wid) {
    repository.deleteById(wid);
    return 1;
//    int index = -1;
//    for(int i=0; i<widgets.size(); i++) {
//      if (widgets.get(i).getId() == id) {
//        index = i;
//        widgets.remove(index);
//        break;
//      }
//    }
//    return 0;
  }
}