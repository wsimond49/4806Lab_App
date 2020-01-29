package access.web;

import access.AddressBookRepository;
import access.addressbook.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository repo;

    @GetMapping("/address/show")
    public String showBuddies(@RequestParam(name = "id") Long id, Model model) {
        Optional<AddressBook> info = repo.findById(id);
        if (info.isPresent()) {
            AddressBook book = info.get();
            model.addAttribute("buddies", book.getBuddies());
            return "show_address";
        } else {
            model.addAttribute("id", id);
            return "show_address_error";
        }
    }

    @GetMapping("/address/remove")
    public String removeAddressBook(@RequestParam(name = "id") Long id, Model model) {
        Optional<AddressBook> info = repo.findById(id);
        model.addAttribute("id", id);
        if (info.isPresent()) {
            AddressBook book = info.get();
            repo.delete(book);
            return "remove_address";
        } else {
            return "remove_address_error";
        }
    }
}
