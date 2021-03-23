package com.example.wbdvsp2102castanedarserverjava.controlers;
import com.example.wbdvsp2102castanedarserverjava.models.Widget;
import com.example.wbdvsp2102castanedarserverjava.services.WidgetService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    return service.createWidgetForTopic(topicId, widget);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/topics/{tid}/widget")
  public List<Widget> findWidgetForTopic (
      @PathVariable("tid") String topicId
  ) {
    return service.findWidgetsForTopic(topicId);
  }
}
