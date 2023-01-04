import { TestBed } from '@angular/core/testing';

import { UserServiceLocalService } from './user-service-local.service';

describe('UserServiceLocalService', () => {
  let service: UserServiceLocalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserServiceLocalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
