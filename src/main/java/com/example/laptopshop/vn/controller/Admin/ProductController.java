package com.example.laptopshop.vn.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.laptopshop.vn.domain.Product;
import com.example.laptopshop.vn.service.ProductService;
import com.example.laptopshop.vn.service.UploadService;

import jakarta.validation.Valid;


@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService  uploadService;
    
    public ProductController(UploadService uploadService,ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }


    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProductPage(Model model,
            @ModelAttribute("newProduct") @Valid Product product, BindingResult newProductBindingResult,
            @RequestParam("imgFile") MultipartFile file) {
                List<FieldError> errors = newProductBindingResult.getFieldErrors();
                for (FieldError error : errors ) {
                System.out.println (">>>"+error.getField() + " - " + error.getDefaultMessage());
                }
              // validate
              if(newProductBindingResult.hasErrors()){
                return "admin/product/create";
            }

            String productImg = this.uploadService.handleSaveUploadFile(file, "product");
            product.setImage(productImg);
            // save data
            this.productService.createProduct(product);

            return "redirect:/admin/product";
        }

         @GetMapping("/admin/product")
        public String getAllProductPage(Model model){
            List<Product> products = this.productService.fetchProducts();
            model.addAttribute("listProduct", products);
            return "admin/product/show";
        }

        @GetMapping("/admin/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
         Product pr = this.productService.fetchProductById(id).get();
            model.addAttribute("product", pr);
            model.addAttribute("id", id);
            return "admin/product/detail";
    }
    @GetMapping("/admin/product/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        Optional<Product> currentProduct = this.productService.fetchProductById(id);

        model.addAttribute("newProduct", currentProduct.get());

        return "admin/product/update";
    }
    @PostMapping("/admin/product/update")
    public String handleUpdateproduct(Model model,
            @ModelAttribute("newProduct") @Valid Product pr, BindingResult newProductBindingResult,
            @RequestParam("imgFile") MultipartFile file) {

        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }
        Product currentProduct = this.productService.fetchProductById(pr.getId()).get();

        if (currentProduct != null) {

            // update new image
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }
            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productService.createProduct(currentProduct);

        }
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("newProduct") Product product) {
        this.productService.deleteProduct(product.getId());
        return "redirect:/admin/product";
    }

}
    


