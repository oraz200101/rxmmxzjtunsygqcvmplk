package kz.example.rxmmxzjtunsygqcvmplk;

import kz.example.rxmmxzjtunsygqcvmplk.mapper.UserMapper;
import kz.example.rxmmxzjtunsygqcvmplk.mapper.UserMapperImpl;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserGetPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.dto.UserRequestPostgresDto;
import kz.example.rxmmxzjtunsygqcvmplk.model.entities.UserPostgres;
import kz.example.rxmmxzjtunsygqcvmplk.repositories.UserPostgresRepository;
import kz.example.rxmmxzjtunsygqcvmplk.services.impl.UserPostgresServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTests {
    @InjectMocks
    private UserPostgresServiceImpl service;
    @Mock
	private UserMapper mapper;
	@Mock
	private UserPostgresRepository repository;
	@BeforeClass
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateUser() {
		UserRequestPostgresDto userRequestPostgresDto = new UserRequestPostgresDto(1L,"Beimishev Meirzhan", LocalDate.parse("2003-05-15"), "87774567890", "87016543210");
		UserPostgres user = new UserPostgres(1L,"Beimishev Meirzhan", LocalDate.parse("2003-05-15"), "87774567890", "87016543210", LocalDateTime.now());

		when(mapper.mapToUserPostgresEntity(userRequestPostgresDto)).thenReturn(user);
		when(repository.save(user)).thenReturn(user);
		when(mapper.mapToUserPostgresDto(user)).thenReturn(new UserGetPostgresDto(user.getId(),user.getName(), user.getDateOfBirth(),user.getFirstPhoneNumber(),user.getSecondPhoneNumber(),user.getCreateDateTime()));

		UserGetPostgresDto userGetPostgresDto = service.createUser(userRequestPostgresDto);
		verify(repository).save(user);
        verify(mapper).mapToUserPostgresEntity(userRequestPostgresDto);
		verify(mapper).mapToUserPostgresDto(user);

		Assert.assertEquals(userGetPostgresDto.getName(), userRequestPostgresDto.getName());
		Assert.assertEquals(userGetPostgresDto.getFirstPhoneNumber(), userRequestPostgresDto.getFirstPhoneNumber());
		Assert.assertEquals(userGetPostgresDto.getSecondPhoneNumber(), userRequestPostgresDto.getSecondPhoneNumber());
		Assert.assertEquals(userGetPostgresDto.getDateOfBirth(), userRequestPostgresDto.getDateOfBirth());
	}
    @Test
	public void testGetUser(){
		UserPostgres user = new UserPostgres(1L,"Beimishev Meirzhan", LocalDate.parse("2003-05-15"), "87774567890", "87016543210", LocalDateTime.now());
		when(repository.findById(user.getId())).thenReturn(Optional.of(user));
		when(mapper.mapToUserPostgresDto(user)).thenReturn(new UserGetPostgresDto(user.getId(),user.getName(), user.getDateOfBirth(),user.getFirstPhoneNumber(),user.getSecondPhoneNumber(),user.getCreateDateTime()));

		UserGetPostgresDto userGetPostgresDto = service.getById(user.getId());

		verify(repository).findById(user.getId());
        verify(mapper).mapToUserPostgresDto(user);
		Assert.assertEquals(userGetPostgresDto.getName(), user.getName());
		Assert.assertEquals(userGetPostgresDto.getFirstPhoneNumber(), user.getFirstPhoneNumber());
		Assert.assertEquals(userGetPostgresDto.getSecondPhoneNumber(), user.getSecondPhoneNumber());
		Assert.assertEquals(userGetPostgresDto.getDateOfBirth(), user.getDateOfBirth());
	}

	@AfterMethod
	public void showMessageAfterTest(ITestResult result) {
		String testName = result.getName();
		int status = result.getStatus();

		if (status == ITestResult.SUCCESS) {
			System.out.println(testName + " completed successfully.");
		} else if (status == ITestResult.FAILURE) {
			System.out.println(testName + " failed.");
		} else if (status == ITestResult.SKIP) {
			System.out.println(testName + " was skipped.");
		}
	}
}
