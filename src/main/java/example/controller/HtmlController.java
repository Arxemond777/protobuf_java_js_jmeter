package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {
    @GetMapping("/flame-graph")
    public String flameGraph(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "flame-graph-view";
    }

    @GetMapping("/flame-graph-def")
    public String flameGraphDef(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "flame-graph-view-def";
    }

    @GetMapping("/flame-graph-gzip")
    public String flameGraphGzip(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "flame-graph-view-gzip";
    }

    @GetMapping("/flame-graph-gzip-proto")
    public String flameGraphGzipProto(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "flame-graph-view-gzip-proto";
    }
}
