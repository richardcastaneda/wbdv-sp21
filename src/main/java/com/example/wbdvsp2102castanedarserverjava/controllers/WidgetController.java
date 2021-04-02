package com.example.wbdvsp2102castanedarserverjava.controllers;
import com.example.wbdvsp2102castanedarserverjava.models.Widget;
import com.example.wbdvsp2102castanedarserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic(
      @PathVariable("tid")String topicId,
      @RequestBody Widget widget
  ) {
    return service.createWidget(topicId, widget);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }


 @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
        @PathVariable ("wid") Long Id,
        @RequestBody Widget widget){
    return service.updateWidget(Id, widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetForTopic (
      @PathVariable("tid") String topicId
  ) {
    return service.findWidgetsForTopic(topicId);
  }

@DeleteMapping("/api/widgets/{wid}")
public Integer deleteWidget(
  @PathVariable("wid") Long Id) {
  return service.deleteWidget(Id);
  }
}
