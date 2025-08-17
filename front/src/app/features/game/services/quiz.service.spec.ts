import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { QuizService } from './quiz.service';

describe('QuizService', () => {
  let service: QuizService;
  let httpTestingController: HttpTestingController;



  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [],
      providers: [
        QuizService, provideHttpClient(),
        provideHttpClientTesting(),
      ]
    });
    service = TestBed.inject(QuizService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    // Verify no outstanding HTTP requests
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


});