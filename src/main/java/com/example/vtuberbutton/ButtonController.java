//package com.example.vtuberbutton;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ButtonController {
//
//    private final ResourceLoader resourceLoader;
//
//    @Autowired
//    public ButtonController(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
//    @GetMapping("/")
//    public String getAudioPage(Model model) {
//        try {
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader.getClassLoader());
//            Resource[] resources = resolver.getResources("classpath:static/audio/*.mp3");
//            Resource[] resources2 = resolver.getResources("classpath:static/1-4audio/*.mp3");
//
//            List<String> audioFileList = new ArrayList<>();
//            for (Resource resource : resources) {
//                // ファイル名を取得してリストに追加
//                String filename = resource.getFilename();
//                // 拡張子を取り除いたファイル名を追加
//                String filenameWithoutExtension = filename.substring(0, filename.lastIndexOf('.'));
//                audioFileList.add(filenameWithoutExtension);
//            }
//
//            List<String> audioFileList2 = new ArrayList<>();
//            for (Resource resource : resources2) {
//                // ファイル名を取得してリストに追加
//                String filename = resource.getFilename();
//                // 拡張子を取り除いたファイル名を追加
//                String filenameWithoutExtension = filename.substring(0, filename.lastIndexOf('.'));
//                audioFileList2.add(filenameWithoutExtension);
//            }
//
//            model.addAttribute("audioFileList", audioFileList);
//            model.addAttribute("audioFileList2", audioFileList2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "kaboku.html";
//    }
//    
//    @GetMapping("/link")
//    public String getLink() {
//        return "link.html";
//    }
//}
package com.example.vtuberbutton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ButtonController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ButtonController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/")
    public String getAudioPage(Model model) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader.getClassLoader());
            Resource[] resources = resolver.getResources("classpath:static/audio/*.mp3");
            
            List<String> audioFileList = new ArrayList<>();
            for (Resource resource : resources) {
                String filename = resource.getFilename();
                String filenameWithoutExtension = filename.substring(0, filename.lastIndexOf('.'));
                audioFileList.add(filenameWithoutExtension);
            }

            model.addAttribute("audioFileList", audioFileList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "button.html";
    }
    
    @GetMapping("/link")
    public String getLink() {
        return "link.html";
    }
}
