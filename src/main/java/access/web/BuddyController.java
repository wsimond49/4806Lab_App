package access.web;

import access.BuddyInfoRepository;
import access.addressbook.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class BuddyController {
    @Autowired
    private BuddyInfoRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        Iterable i = repo.findAll();
        List<BuddyInfo> result = new ArrayList<BuddyInfo>();
        i.forEach((x) -> {result.add((BuddyInfo) x);});
        model.addAttribute("buddies", result.toArray(new BuddyInfo[0]));
        model.addAttribute("buddy", new BuddyInfo());
        return "index";
    }

    @GetMapping(value = "/buddy/count")
    @ResponseBody
    public String count() {
        return String.valueOf(repo.count());
    }

    @PostMapping("/buddy/add")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        repo.save(buddy);
        return getBuddy(buddy.getId(), model);
    }

    @GetMapping("/buddy/show")
    public String getBuddy(@RequestParam(name = "id") Long id, Model model) {
        Optional<BuddyInfo> info = repo.findById(id);
        if (info.isPresent()) {
            BuddyInfo buddy = info.get();
            model.addAttribute("name", buddy.getName());
            model.addAttribute("address", buddy.getAddress());
            model.addAttribute("birthday", buddy.getBirthday());
            model.addAttribute("company", buddy.getCompany());
            model.addAttribute("phonenumber", buddy.getPhoneNumber());
            return "show_buddy";
        } else {
            model.addAttribute("id", id);
            return "show_buddy_error";
        }
    }

    @GetMapping("/buddy/remove")
    public String removeBuddy(@RequestParam(name = "id") Long id, Model model) {
        Optional<BuddyInfo> info = repo.findById(id);
        if (info.isPresent()) {
            BuddyInfo buddy = info.get();
            model.addAttribute("name", buddy.getName());
            model.addAttribute("address", buddy.getAddress());
            model.addAttribute("birthday", buddy.getBirthday());
            model.addAttribute("company", buddy.getCompany());
            model.addAttribute("phonenumber", buddy.getPhoneNumber());
            repo.delete(buddy);
            return "remove_buddy";
        } else {
            model.addAttribute("id", id);
            return "remove_buddy_error";
        }
    }
}
