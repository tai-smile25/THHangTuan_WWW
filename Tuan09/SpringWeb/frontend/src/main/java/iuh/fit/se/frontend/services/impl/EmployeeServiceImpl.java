package iuh.fit.se.frontend.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import iuh.fit.se.frontend.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.frontend.entities.Employee;
import iuh.fit.se.frontend.services.EmployeeService;
import iuh.fit.se.frontend.utils.ApiResponse;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private RestClient restClient;
    private ObjectMapper objectMapper;

    @Value("${backend.api.url}")
    private String ENDPOINT;

    @Autowired
    public EmployeeServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public ApiResponse findById(int id) {
        return restClient.get().uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }

                        ApiResponse apiResponse = objectMapper.readValue(body, ApiResponse.class);
                        apiResponse.setData(objectMapper.convertValue(apiResponse.getData(), new TypeReference<Employee>() {}));
                        return apiResponse;

                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to read employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse findAll() {
        return restClient.get().uri(ENDPOINT + "/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }

                        ApiResponse apiResponse = objectMapper.readValue(body, ApiResponse.class);
                        apiResponse.setData(objectMapper.convertValue(apiResponse.getData(), new TypeReference<List<Employee>>() {}));
                        return apiResponse;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to read employee list: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse save(Employee employee) {
        return restClient.post().uri(ENDPOINT + "/employees")
                .accept(MediaType.APPLICATION_JSON)
                .body(employee)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }

                        return objectMapper.readValue(body, ApiResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to save employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse update(int id, Employee employee) {
        return restClient.put().uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .body(employee)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }

                        return objectMapper.readValue(body, ApiResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to update employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse delete(int id) {
        return restClient.delete().uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }

                        return objectMapper.readValue(body, ApiResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to delete employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse search(String keyword) {
        return restClient.get().uri(ENDPOINT + "/employees?keyword={keyword}", keyword)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            return ApiResponse.noContent();
                        }
                        ApiResponse apiResponse = objectMapper.readValue(body, ApiResponse.class);

                        apiResponse.setData(objectMapper.convertValue(
                                apiResponse.getData(),
                                new TypeReference<List<Employee>>() {}
                        ));

                        return apiResponse;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to search employee list: " + e.getMessage());
                    }
                });
    }

    @Override
    public PageResponse<Employee> findAllWithPaging(int page, int size, String sort) {

        String url = UriComponentsBuilder.fromHttpUrl(ENDPOINT + "/employeesHasPage")
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sort", sort)
                .toUriString();

        return restClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream is = response.getBody()) {
                        return objectMapper.readValue(is, new TypeReference<PageResponse<Employee>>() {});
                    }
                });
    }
}