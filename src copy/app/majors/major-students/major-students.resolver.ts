import { inject } from "@angular/core"
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router"
import { MajorService } from "../../services/major.service"
import { Student } from "../../models/student.model"

export const MajorStudentsResolver: ResolveFn<Student[]> = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  return inject(MajorService).findStudentsFromMajor(route.params["id"])
}
